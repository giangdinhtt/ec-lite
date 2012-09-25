/*
 * Copyright (c) JForum Team
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, 
 * with or without modification, are permitted provided 
 * that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above 
 * copyright notice, this list of conditions and the 
 * following  disclaimer.
 * 2)  Redistributions in binary form must reproduce the 
 * above copyright notice, this list of conditions and 
 * the following disclaimer in the documentation and/or 
 * other materials provided with the distribution.
 * 3) Neither the name of "Rafael Steil" nor 
 * the names of its contributors may be used to endorse 
 * or promote products derived from this software without 
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT 
 * HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, 
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL 
 * THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE 
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE
 * 
 * Created on 02/11/2004 12:45:37
 * The JForum Project
 * http://www.jforum.net
 */
package org.cath.ec.preferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * General utilities methods for loading configurations for JForum.
 * 
 * @author Rafael Steil
 * @version $Id: ConfigLoader.java,v 1.30 2007/07/27 15:42:56 rafaelsteil Exp $
 */
public class ConfigLoader {
    private static final Logger logger = Logger.getLogger(ConfigLoader.class);
    private static CacheEngine cache;

    /**
     * Start ( or restart ) <code>SystemGlobals</code>. This method loads all
     * configuration keys set at <i>SystemGlobals.properties</i>,
     * <i>&lt;user.name&gt;.properties</i> and database specific stuff.
     * 
     * @param appPath
     *            The application root's directory
     */
    public static void startSystemglobals(String appPath, String mainConfigurationFile) {
        SystemGlobals.initGlobals(appPath, mainConfigurationFile);// appPath + "/WEB-INF/config/SystemGlobals.properties");
    }

    /**
     * Loads module mappings for the system.
     * 
     * @param baseConfigDir
     *            The directory where the file <i>modulesMapping.properties</i>
     *            is.
     * @return The <code>java.util.Properties</code> instance, with the loaded
     *         modules
     */
    public static Properties loadModulesMapping(String baseConfigDir) {
        FileInputStream fis = null;
        Properties modulesMapping = null;

        try {
            modulesMapping = new Properties();
            fis = new FileInputStream(baseConfigDir + "/modulesMapping.properties");
            modulesMapping.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return modulesMapping;
    }

    /**
     * Listen for changes in common configuration files. The watched files are:
     * <i>generic_queries.sql</i>, <i>&lt;database_name&gt;.sql</i>,
     * <i>SystemGlobals.properties</i> and <i>&lt;user.name&gt;.properties</i>
     */
    public static void listenForChanges() {
        int fileChangesDelay = SystemGlobals.getIntValue(ConfigKeys.FILECHANGES_DELAY);

        if (fileChangesDelay > 0) {
            // System Properties
            FileMonitor.getInstance().addFileChangeListener(new SystemGlobalsListener(),
                    SystemGlobals.getValue(ConfigKeys.DEFAULT_CONFIG), fileChangesDelay);
        }
    }

    public static void listenAdditionalConfig() {
        int fileChangesDelay = SystemGlobals.getIntValue(ConfigKeys.FILECHANGES_DELAY);

        if (fileChangesDelay > 0) {
            if (new File(SystemGlobals.getValue(ConfigKeys.ADDITION_CONFIG)).exists()) {
                FileMonitor.getInstance().addFileChangeListener(new SystemGlobalsListener(),
                        SystemGlobals.getValue(ConfigKeys.ADDITION_CONFIG), fileChangesDelay);
            }
        }
    }

    public static void startCacheEngine() {
        try {
            String cacheImplementation = SystemGlobals.getValue(ConfigKeys.CACHE_IMPLEMENTATION);
            logger.info("Using cache engine: " + cacheImplementation);

            cache = (CacheEngine) Class.forName(cacheImplementation).newInstance();
            cache.init();

            String s = SystemGlobals.getValue(ConfigKeys.CACHEABLE_OBJECTS);
            if (s == null || s.trim().equals("")) {
                logger.warn("Cannot find Cacheable objects to associate the cache engine instance.");
                return;
            }

            String[] cacheableObjects = s.split(",");
            for (int i = 0; i < cacheableObjects.length; i++) {
                logger.info("Creating an instance of " + cacheableObjects[i]);
                Object o = Class.forName(cacheableObjects[i].trim()).newInstance();

                if (o instanceof Cacheable) {
                    ((Cacheable) o).setCacheEngine(cache);
                } else {
                    logger.error(cacheableObjects[i] + " is not an instance of net.jforum.cache.Cacheable");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopCacheEngine() {
        if (cache != null) {
            cache.stop();
        }
    }
}
