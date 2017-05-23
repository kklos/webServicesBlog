/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(document).ready(function($) {

                 $('#contentButton').on('click', function (e) {
                            addNewComment();
                        })

	});

function addNewComment() {

		var search = {}
                
		search["content"] = $("#content").val();
                search["postId"] = parseInt($(".postId").text());

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8084/account/comment/addComment",
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});

	}
    

