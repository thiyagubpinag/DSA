package java9;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Features {
    static class Blog {
        private String authorName;
        private List<String> comments;

        public Blog(String authorName, List<String> comments) {
            this.authorName = authorName;
            this.comments = comments;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public List<String> getComments() {
            return comments;
        }

        public void setComments(List<String> comments) {
            this.comments = comments;
        }
    }



    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 5, 5);

        Map<Integer, Long> result = numbers.stream()
                .filter(val -> val > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println(result);
        result = numbers.stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> val > 3, Collectors.counting())));

        System.out.println(result);

        Blog blog1 = new Blog("1", List.of("Nice", "Very Nice"));
        Blog blog2 = new Blog("2", List.of("Disappointing", "Ok", "Could be better"));
        Blog blog3 = new Blog("1", List.of("Bro", "Great"));
        List<Blog> blogs = List.of(blog1, blog2,blog3);

        Map<String,  List<List<String>>> authorComments1 = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.mapping(Blog::getComments, Collectors.toList())));

        System.out.println(authorComments1);

        Map<String, List<String>> authorComments2 = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.flatMapping(blog -> blog.getComments().stream(),
                                Collectors.toList())));


        Map<String,List<String>> bList=blogs.stream().collect(
                Collectors.groupingBy(Blog::getAuthorName,
                Collectors.flatMapping(blog->blog.getComments().stream(),Collectors.toList())));

        System.out.println(bList);

        System.out.println(authorComments2);
    }
}
