define(function(){
    
    function Post(name, content, id, title, addedBy, addedAt, isPrivate, comments, tags){
        this.name = name || 'Default name';
        this.content = content || 'Default content';
        this.id = id;
        this.title = title; 
        this.content = content; 
        this.addedBy = addedBy;
        this.addedAt = addedAt;
        this.isPrivate = isPrivate;
        this.comments = comments;
        this.tags = tags;
    }
    
    return Post;
});