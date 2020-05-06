package com.company;

public class Post {
    private static int count = 0;

    private String headline;
    private String context;
    private int id;

    public Post(String headline, String context){
        this.headline = headline;
        this.context = context;
        this.id = ++count;
    }

    public String getHeadline() {
        return this.headline;
    }

    public boolean isTextInHeadline(String text){
        var textCount = text.length();
        var index = text.length();
        var isAvailable = false;
        for (int i=0; i<this.headline.length() - textCount; i++){
            var curWord = this.headline.substring(i, index);
            if (curWord.equals(text)){
                isAvailable = true;
                break;
            }
            index++;
        }

        return isAvailable;
    }

    public int isTextInContext(String text){
        var textCount = text.length();
        var index = text.length();
        var totalCount = 0;
        for (int i=0; i<this.context.length() - textCount; i++){
            var curWord = this.context.substring(i, index);
            if (curWord.equals(text)){
                totalCount++;
            }
            index++;
        }
        return totalCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + this.id + '\'' +
                ", headline='" + this.headline + '\'' +
                ", context=" + this.context +
                '}';
    }
}
