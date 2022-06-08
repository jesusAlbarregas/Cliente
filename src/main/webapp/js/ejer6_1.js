$(document).ready(function () {

    $('#btnAdd').click(function () {
        var num = $('.clone').length; // how many "duplicatable" input fields we currently have
        console.log("numero de inputs " + num);
        var newNum = new Number(num + 1); // the numeric ID of the new input field being added
        console.log("nuevo número " + newNum);
        // create the new element via clone(), and manipulate it's ID using newNum value
        var newElem = $('#input' + num).clone().attr('id', 'input' + newNum);
        console.log("nuevo elemento " + newElem);
        // manipulate the name/id values of the input inside the new element
        newElem.children(':last').attr('id', 'aficion' + newNum).attr('name', 'aficion[]');
        

        // insert the new element after the last "duplicatable" input field
        $('#input' + num).after(newElem);
        newElem.val("");
        

        // business rule: you can only add 10 names
        if (newNum === 10)
            $('#btnAdd').attr('disabled', 'disabled');
    });

    

});

