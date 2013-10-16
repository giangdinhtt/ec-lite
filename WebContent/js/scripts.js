/**
 * Fade-in/fade-out panel
 */
var content = $('.fading-panel');
content.inner = $('.fading-panel-inner'); // inner div needed to get size of content when closed

// css transition callback
content.on('transitionEnd webkitTransitionEnd transitionend oTransitionEnd msTransitionEnd', function(e){
  if(content.hasClass('open')){
    content.css('max-height', 9999); // try setting this to 'none'... I dare you!
  }
});

$('.user-login-open').on('click touchstart', function(e){
  content.toggleClass('open closed');
  content.contentHeight = content.outerHeight();
  
  if(content.hasClass('closed')){
    // disable transitions & set max-height to content height
    content.removeClass('transitions').css('max-height', content.contentHeight);
    setTimeout(function(){
      
      // enable & start transition
      content.addClass('transitions').css({
        'max-height': 0,
        'opacity': 0
      });
    }, 10); // 10ms timeout is the secret ingredient for disabling/enabling transitions
    // chrome only needs 1ms but FF needs ~10ms or it chokes on the first animation for some reason
  } else if(content.hasClass('open')){  
    content.addClass('transitions').css({
      'max-height': 0,
      'opacity': 0
    });

    content.contentHeight += content.inner.outerHeight(); // if closed, add inner height to content height
    content.css({
      'max-height': content.contentHeight,
      'opacity': 1
    });
  }
});

/**
 * Utilities
 */
String.prototype.trimAll = function() {
		return this.replace(/^\s+|(\s+(?!\S))/mg, " ").trim();
	};

	String.prototype.normalize = function() {
        return this.replace(/\s{2,}/g, ' ');
    };

	String.prototype.insert = function(position, str) {
		return [this.slice(0, position), str, this.slice(position)].join('');
	};

	function checkNull(str) {
	    return str ? str : '';	
	}

	function highlight(str, pattern) {
		var indexes = [];
		var lowercase = ('' + str).toLowerCase();
		var lowercasePattern = pattern.toLowerCase();
		var len = lowercasePattern.length;
		var idx = lowercase.indexOf(lowercasePattern);
		while (idx >= 0) {
			indexes.push(idx);
			idx = lowercase.indexOf(lowercasePattern, idx + lowercasePattern.length);
		}
 		var result = ('' + str);
 	    for (i = indexes.length - 1; i >= 0; i --) {
 	    	result = result.insert(indexes[i] + len, '</span>').insert(indexes[i], '<span class="highlight">');
 	    }
 	    return result;
	}