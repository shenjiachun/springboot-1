$(function(){
    $.ajax({
        type: "GET",
        url: "get",
        data: {},
        dataType: "json",
        success: function(data){
            // $('#dataBody').empty();   //清空resText里面的所有内容
            var html = '';
            $.each(data, function(commentIndex, comment){
                html +="<td>"+comment['name']+"</td>" +
                    "<td>"+comment['price']+"</td>" +
                    "<td>"+comment['count']+"</td>" +
                    "<td><img src='data:image/jpg;base64,"+comment['bytes']+"'></td>";
            });
            $('#dataBody').html(html);
        }
    });
});