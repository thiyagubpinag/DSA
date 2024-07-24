package design.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class SocialMediaDemo {

    // Interface for accessing news feed posts
    public interface NewsFeedIterator {
        boolean hasNext();
        Post next();
    }

    // Class representing a news feed post
    public static class Post {
        private String content;
        private String author;

        public Post(String content, String author) {
            this.content = content;
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }
    }

    // Concrete implementation of NewsFeed (aggregate)
    public static class SocialMediaNewsFeed implements Iterable<Post> {

        private List<Post> posts;

        public SocialMediaNewsFeed() {
            this.posts = createDummyPosts();
        }

        // Creates a custom iterator following a specific logic (e.g., prioritizing likes)
        @Override
        public RankedNewsFeedIterator iterator() {
            return new RankedNewsFeedIterator(posts);
        }

        public FirstTwoPosts getFirstTwoPosts(){
            return new FirstTwoPosts(posts);
        }

        // Create dummy posts for demonstration
        private List<Post> createDummyPosts() {
            List<Post> posts = new ArrayList<>();
            posts.add(new Post("Went hiking today! ", "Alice"));
            posts.add(new Post("Just finished a new painting. What do you think? ", "Bob"));
            posts.add(new Post("Trying out this new recipe.  #foodie", "Charlie"));
            posts.add(new Post("Congratulations to Sarah on her promotion! ", "David"));
            return posts;
        }
    }

    private static class FirstTwoPosts implements Iterator<Post>{

        private List<Post> posts;
        private int currentIndex;

        public FirstTwoPosts(List<Post> posts) {
            this.posts = posts;
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < 2;
        }

        @Override
        public Post next() {
            if (hasNext()) {
                return posts.get(currentIndex++);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    // Concrete implementation of NewsFeedIterator with prioritization logic (dummy in this case)
    private static class RankedNewsFeedIterator implements Iterator<Post> {

        private List<Post> posts;
        private int currentIndex;

        public RankedNewsFeedIterator(List<Post> posts) {
            this.posts = posts;
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < posts.size();
        }

        @Override
        public Post next() {
            if (hasNext()) {
                return posts.get(currentIndex++);
            } else {
                throw new NoSuchElementException();
            }
        }

    }



    // Usage example
    public static void main(String[] args) {

        SocialMediaNewsFeed feed = new SocialMediaNewsFeed();
        RankedNewsFeedIterator iterator =  feed.iterator();
        FirstTwoPosts iterator1=feed.getFirstTwoPosts();

        while(iterator1.hasNext()){
            Post post = iterator1.next();
            System.out.println(post.getContent() + " by " + post.getAuthor());
        }

        System.out.println("**Social Media News Feed**");
        while (iterator.hasNext()) {
            Post post = iterator.next();
            System.out.println(post.getContent() + " by " + post.getAuthor());
        }
    }
}
