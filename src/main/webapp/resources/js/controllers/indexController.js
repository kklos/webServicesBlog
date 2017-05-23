$(document).ready(function() {
    var url = window.location.pathname;
    console.log(url);
    
    if(url.indexOf("index") >= 0)
        getAllItems();
    
    if(url.indexOf("blog") >= 0)
    {
        var id = url.substring(url.lastIndexOf('/'));
        getSingleBlog(id);
    }
    if(url.indexOf("post") >= 0)
    {      
        var id = url.substring(url.lastIndexOf('/'));
        getSingleItem(id);
    }
    if(url.indexOf("panelAdmin") >= 0)
        getAllBlogs();
});


