var userName;
$(document).ready(function ($) {
    userName = $("#UN").val();

})
function jumpHtml1(parent, page) {
    if (userName == null) {
        location.href = "/";
    } else if (name != null) {
        location.href = "/jump/" + parent + '/' + page;
    }
}

