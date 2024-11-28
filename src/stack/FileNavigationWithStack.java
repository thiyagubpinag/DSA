package stack;

import java.io.File;
import java.util.Stack;

public class FileNavigationWithStack {
    public static void main(String[] args) {
        String filePath = "a/b/../d";

        // Split the file path into components using "/" as the delimiter
        String[] components = filePath.split("/");

        // Create a stack to store the path components
        Stack<String> pathStack = new Stack<>();

        // Iterate over the components and process them
        for (String component : components) {
            if (!component.isEmpty()) {
                if (component.equals("..")) {
                    // If the component is "..", pop the top element from the stack
                    if (!pathStack.isEmpty()) {
                        pathStack.pop();
                    }
                } else {
                    // Otherwise, push the component onto the stack
                    pathStack.push(component);
                }
            }
        }

        // Reconstruct the final path from the remaining elements in the stack
        StringBuilder finalPath = new StringBuilder();
        for (String component : pathStack) {
            finalPath.append(component).append("/");
        }

        // Remove the trailing "/" if present
        if (finalPath.length() > 0) {
            finalPath.deleteCharAt(finalPath.length() - 1);
        }

        // Get the absolute path of the file
        File file = new File(finalPath.toString()).getAbsoluteFile();

        // Check if the file or directory exists
        if (file.exists()) {
            System.out.println("File or directory exists at: " + file.getAbsolutePath());
        } else {
            System.out.println("File or directory not found.");
        }
    }
}
