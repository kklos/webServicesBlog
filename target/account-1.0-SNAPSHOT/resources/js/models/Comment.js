define(function(){
    
    function Comment(content, id, isAnnonimous, addedBy, owner, post){
        this.id = id;
        this.content = content || 'Default content';
        this.isAnnonimous = isAnnonimous; 
        this.addedBy = addedBy; 
        this.owner = owner;
        this.post = post;
    }
    
    return Comment;
});