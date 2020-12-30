
function ss() {
    var len = $('#storyBox li').length;
    var webWidth = 0;
    var cur = len;
    var lock = false;
    $('#storyBox li').clone().appendTo('#storyBox ul');
    init();

    $(window).resize(function () {
        init();
    });
    $('.storyBox .arrLeft').on('click', function () {
        if (!lock) {
            cur = cur - 1;
            movePic();
            lock = true;
        }
    });
    $('.storyBox .arrRight').on('click', function () {
        if (!lock) {
            cur = cur + 1;
            movePic();
            lock = true;
        }
    });

    function init() {
        webWidth = $(window).width();
        $('#storyBox ul').css({ 'width': 1200 * len * 2, 'margin-left': -cur * 1200 + (webWidth - 1200) / 2 });
        $('#storyBox .shadeLeft, #storyBox .shadeRight').css({ 'width': (webWidth - 1200) / 2 });
        $('#storyBox li').eq(cur).find('div').show();
    }

    function movePic() {
        $('#storyBox li').find('div').fadeOut(500);
        $('#storyBox ul').delay(500).animate({ 'margin-left': -cur * 1200 + (webWidth - 1200) / 2 }, function () {
            lock = false;
            $(this).find('li').eq(cur).find('div').fadeIn();
            if (cur <= 1) {
                cur = len + cur;
                init();
            }
            if (cur >= 2 * len - 2) {
                cur = len - 2;
                init();
            }
        });
    }
}