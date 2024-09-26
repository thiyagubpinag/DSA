package java9;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Java8Features {
    static class BlogPost {
        String title;
        String author;
        BlogPostType type;
        int likes;

        public BlogPost(String title, String author, BlogPostType type, int likes) {
            this.title = title;
            this.author = author;
            this.type = type;
            this.likes = likes;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public BlogPostType getType() {
            return type;
        }

        public void setType(BlogPostType type) {
            this.type = type;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        @Override
        public String toString() {
            return "BlogPost{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", type=" + type +
                    ", likes=" + likes +
                    '}';
        }

    }

    static enum BlogPostType {
        NEWS,
        REVIEW,
        GUIDE;

        @Override
        public String toString() {
            return "BlogPostType{}";
        }
    }

    static class Tuple {
        BlogPostType type;
        String author;

        public Tuple(BlogPostType type, String author) {
            this.type = type;
            this.author = author;
        }

        public BlogPostType getType() {
            return type;
        }

        public void setType(BlogPostType type) {
            this.type = type;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple tuple)) return false;
            return type == tuple.type && Objects.equals(author, tuple.author);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, author);
        }
    }



    public static void main(String[] args) {
        List<BlogPost> posts = Arrays.asList(
                new BlogPost("T1", "A1", BlogPostType.NEWS, 100),
                new BlogPost("T2", "A2", BlogPostType.NEWS, 800),
                new BlogPost("T1", "A1", BlogPostType.REVIEW, 300),
                new BlogPost("T2", "A2", BlogPostType.NEWS, 400),
                new BlogPost("T3", "A3", BlogPostType.GUIDE, 500)
        );

        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType));


        System.out.println(postsPerType);

        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));

        System.out.println(postsPerTypeAndAuthor);

        Map<BlogPostType, Double> averageLikesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));

        System.out.println(averageLikesPerType);

        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
                .collect(groupingBy(BlogPost::getType, minBy(comparingInt(BlogPost::getLikes))));

        System.out.println(maxLikesPerPostType);

        Map<BlogPostType, Integer> likesPerTypeMap = posts.stream()
                .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));

        System.out.println(likesPerTypeMap);

        Optional<Map.Entry<BlogPostType, Integer>> max=likesPerTypeMap.entrySet().stream().max(comparing(map->map.getValue()));

        System.out.println(max);

        List<Integer> temp=Arrays.asList(1,2,3,4,5);
        Optional<Integer> max1=temp.stream().max(comparing(Integer::intValue));
        Map<BlogPostType, Double> max2=posts.stream().collect(groupingBy(BlogPost::getType,averagingInt(BlogPost::getLikes)));
        System.out.println(max2);
    }
}
