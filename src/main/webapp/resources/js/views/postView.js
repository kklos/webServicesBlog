var Test = (function() {
    console.log("2");
  var content = $('#posts');

  function init(blog) {
      console.log(blog);
      var elements = "";
      for(var i = 0; i < blog.posts.length; i++)
      {
     elements += '<h2>' 
                +'<a href="/account/post/'+ blog.posts[i].id+'">'+ blog.posts[i].title + '</a>'  
                +'</h2>'
                +'<p class="lead">'
                    +'by '+ blog.posts[i].addedBy+' <a href="index.php"></a>'
                +'</p>'
                +'<p><span class="glyphicon glyphicon-time"></span> Posted on '+ blog.posts[i].addedAt
                +'<hr>'
                +'<p>'+ blog.posts[i].content+'</p>'
                +'<a class="btn btn-primary" href="/account/post/'+ blog.posts[i].id+'">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>'
                +'<hr>';
     }
     content.html(elements);
  };
  
  function initSinglePage(post) {
      
     var element = "";
     element = "by <a href=''>"+post.addedBy+"</a>"
     $('.postId').text(post.id);
     $('h1').html(post.title);
     $('.addedBy').html(element);
     $('.content').text(post.content)
     $('.addedAt').text(post.addedAt)
     
     var comment = "";
     
     for(var i = 0; i < post.comments.length; i++)
     {
         comment +=
         +"<div class='media'>"
         +"<div class='media-body'>"
         + "<h4 class='media-heading'>"
         +"Added by: "+ post.comments[i].addedBy.username
         +"<small>August 25, 2014 at 9:30 PM</small>"
         +"</h4>"
         +""+post.comments[i].content+""
         +"</div>"
         +"</div>"
     }
     $('#comment').html(comment);
     
     
  };

  return {
    init: init,
    initSinglePage : initSinglePage
  }
})();