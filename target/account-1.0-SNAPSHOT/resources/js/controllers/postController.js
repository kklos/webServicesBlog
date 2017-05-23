jQuery(document).ready(function($) {

                 $('#addNewPostButton').on('click', function (e) {
                            addNewPost();
                        })
	});

function getAllItems(){
        var data;
        getItemsFromDatabase(function(d){
            console.log("1");
            Test.init(d);
            console.log(d);
            });
    }


function getSingleItem(id){
        var data;
        getSingleItemFromDatabase(function(d){
            Test.initSinglePage(d);
            
            console.log(d);
            }, id);
    }
    

      
function getSingleItemFromDatabase(callback, id){
		jQuery.ajax({
			type : "GET",
			contentType : "application/json",
			url : "http://localhost:8084/account/post/getPostById/"+ id,
			dataType : 'json',
                         async: false,
			timeout : 100000,
			success : function(response) {
                                callback(response);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
				//enableSearchButton(true);
			}
		});
    }

function getItemsFromDatabase(callback){
		jQuery.ajax({
			type : "GET",
			contentType : "application/json",
			url : "http://localhost:8084/account/post/getAllPosts",
			dataType : 'json',
                         async: false,
			timeout : 100000,
			success : function(response) {
                                callback(response);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
				//enableSearchButton(true);
			}
		});
    }
  
  function addNewPost() {

		var search = {}
                
		search["content"] = tinyMCE.activeEditor.getContent({format : 'text'});
                search["title"] = $("#title").val();

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8084/account/post/addPost",
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