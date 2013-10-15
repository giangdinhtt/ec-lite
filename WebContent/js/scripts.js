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