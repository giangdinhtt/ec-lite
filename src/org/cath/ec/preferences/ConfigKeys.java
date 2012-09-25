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
 * Created on May 29, 2004 by pieter
 * The JForum Project
 * http://www.jforum.net
 */
package org.cath.ec.preferences;

/**
 * Encapsulate all configuration keys in constants. This is more typesafe and
 * provides a nice overview of all configuration keys. Last but not least this
 * lets us autocomplete configuration keys under eclipse ;-)
 * 
 * @author Pieter Olivier
 * @version $Id: ConfigKeys.java,v 1.120 2007/09/21 15:54:30 rafaelsteil Exp $
 */

public class ConfigKeys {
    public static final String ADDITION_CONFIG = "addition.config";
    public static final String APPLICATION_PATH = "application.path";
    public static final String CACHE_IMPLEMENTATION = "cache.engine.implementation";
    public static final String CACHEABLE_OBJECTS = "cacheable.objects";
    public static final String CONFIG_DIR = "config.dir";
    public static final String DATE_TIME_FORMAT = "dateTime.format";
    public static final String DEFAULT_CONFIG = "default.config";
    public static final String FILECHANGES_DELAY = "file.changes.delay";
    public static final String RESOURCE_DIR = "resource.dir";
    public static final String UPLOAD_DIR = "upload.dir";
    public static final String UPLOAD_TEMP_DIR = "upload.temp.dir";
    public static final String IMAGE_DIR = "image.dir";
    public static final String AVATAR_DIR = "avatar.dir";
    private ConfigKeys() {
    }
}
