package com.company;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private List<Post> posts;

    public Blog(){
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public void isTextContainedInPostsContext(String text){
        if (posts.size() == 0){
            System.out.println("There are no posts in this blog! Please add some.");
            return;
        }

        var isTextContained = false;

        for (Post post:this.posts) {
            var textCountInPostContent = post.isTextInContext(text);
            if (textCountInPostContent > 0){
                isTextContained = true;
                System.out.println(post.getHeadline());
            }
        }

        if (!isTextContained)
            System.out.println("Sorry but we couldn't find this text in any post content");
    }

    @Override
    public String toString() {
        return "Blog{" +
                "posts=" + posts +
                '}';
    }
}
