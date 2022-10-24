$(document).ready(function () {
    $("body").on('click', '.editBtn', function (event) {
        event.preventDefault ? event.preventDefault() : (event.returnValue = false);
        $.get($(this).attr('href'), function (user) {
            $('#id1').val(user.id);
            $('#firstname1').val(user.firstName);
            $('#lastname1').val(user.lastName);
            rolesSelect(user.roles)
        });
        $('#editUser').modal();
    });

    $('body').on('click', '.deleteBtn', function (event) {
        event.preventDefault ? event.preventDefault() : (event.returnValue = false);
        $.get($(this).attr('href'), function (user) {
            $('#id2').val(user.id);
            $('#firstname2').val(user.firstName);
            $('#lastname2').val(user.lastName);
        });
        $('#deleteUser').modal();
    });
})

function rolesSelect(roles) {
    const element = document.getElementById("roles1")
    element.getElementsByTagName('option')[0].selected = false
    element.getElementsByTagName('option')[1].selected = false
    if (roles.length === 1) (roles[0].role === "ROLE_USER") ? i = 1 : i = 0
    element.getElementsByTagName('option')[i].selected = true
}