jQuery(document).ready(function($) {

                 $('#addNewBlogButton').on('click', function (e) {
                            addNewBlog();
                        })
	});


function getAllBlogs(){
        getBlogsFromDatabase(function(d){
            Blog.init(d);
            console.log(d);
            });
    }
    
function getSingleBlog(id){
        getSingleBlogFromDatabase(function(d){
           Test.init(d);
            
            console.log(d);
            }, id);
    }

function getSingleBlogFromDatabase(callback, id){
		jQuery.ajax({
			type : "GET",
			contentType : "application/json",
			url : "http://localhost:8084/account/blog/getBlogById/"+ id,
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

function getBlogsFromDatabase(callback){
		jQuery.ajax({
			type : "GET",
			contentType : "application/json",
			url : "http://localhost:8084/account/blog/getAllBlogs",
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
			}
		});
    }
  
  
function addNewBlog() {

		var search = {}
                
		search["description"] = tinyMCE.activeEditor.getContent({format : 'text'});
                search["title"] = $("#title").val();

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8084/account/blog/addBlog",
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
