var cid = 0;
$(document).on('pagecreate', '#page1', function () {
    $('#add').click(function(e) {
        var c1 = '<div data-role="collapsible" class="entry" id="col_' + (++cid) + '"><h3>' + "Collapsible " + cid + 
        '<button id="remove_' + cid +'" data-inline="true" class="my-cbtn ui-btn ui-icon-delete ui-btn-iconpos-right ui-btn-icon-notext ui-corner-all">Delete</button>' + 
        '</h3>' + "Text " + cid + 
        '</div>';
        $('#col').append(c1);
	$('#remove_'+ cid).trigger('create')
        .click(function(e) {
            $(this).parents('.entry').remove();
            $('#col').collapsibleset('refresh');
	}); 
        //$('#col').parent().trigger('create');
	$('#col').collapsibleset('refresh');
    });
    
});
