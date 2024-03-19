import java.util.List;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        SimpleApiHttpClient client = new SimpleApiHttpClient();
        String url = "https://jsonplaceholder.typicode.com/posts";

        try {
            String jsonResponse = client.fetchData(url);
            List<Post> posts = client.parseJsonPosts(jsonResponse);

            for (Post post : posts) {
                System.out.println("Post ID: " + post.getId());
                System.out.println("User ID: " + post.getUserId());
                System.out.println("Title: " + post.getTitle());
                System.out.println("Body: " + post.getBody());
                System.out.println("--------------------------------------");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
