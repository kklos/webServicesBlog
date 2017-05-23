var Blog = (function() {
    console.log("23");
  var content = $('#blogs');

  function init(blogs) {
      var elements = "";
      console.log(blogs);
      for(var i = 0; i < blogs.length; i++)
      {
          if(blogs[i].owner != null)
          {
           elements += '<h2>' 
                +'<a href="/account/blog/'+ blogs[i].id+'">'+blogs[i].title+ '</a>'  
                +'</h2>'
                +'<p class="lead">'
                    +'by '+ blogs[i].owner.username+' <a href="index.php"></a>'
                +'</p>'
                +'<p><span class="glyphicon glyphicon-time"></span> Posted on '+blogs[i].addedAt
                +"<hr>"
                +"<img class='img-responsive' src='http://icons.iconarchive.com/icons/artua/mac/512/Setting-icon.png' alt=''>"
                +"<hr>"
                +'<p>'+blogs[i].description+'</p>'
                +'<a class="btn btn-primary" href="/account/blog/'+ blogs[i].id+'">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>'
                +'<hr>';
          }
     }
     content.html(elements);
  };
  
  return {
    init: init
  }
})();
