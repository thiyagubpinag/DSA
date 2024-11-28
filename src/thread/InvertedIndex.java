package thread;

import java.util.*;

public class InvertedIndex {
    private Map<String, Set<Integer>> index;
    private Map<String, Integer> documentCounts;

    public InvertedIndex() {
        index = new HashMap<>();
        documentCounts = new HashMap<>();
    }

    public void addDocument(String document, List<String> terms) {
        int documentId = documentCounts.size();
        documentCounts.put(document, documentId);
        for (String term : terms) {
            Set<Integer> documentIds = index.getOrDefault(term, new HashSet<>());
            documentIds.add(documentId);
            index.put(term, documentIds);
        }
    }

    public List<Integer> search(String query) {
        List<Set<Integer>> termDocumentSets = new ArrayList<>();
        for (String term : query.split("\\s+")) {
            Set<Integer> termDocuments = index.get(term);
            if (termDocuments == null) {
                return new ArrayList<>(); // No documents match this term
            }
            termDocumentSets.add(termDocuments);
        }

        // Efficiently compute the intersection of sets
        Set<Integer> result = termDocumentSets.get(0);
        for (int i = 1; i < termDocumentSets.size(); i++) {
            //result = Sets.intersection(result, termDocumentSets.get(i));
        }

        return new ArrayList<>(result);
    }

    public int getDocumentCount(String document) {
        Integer documentId = documentCounts.get(document);
        return documentId == null ? -1 : documentId;
    }

    public static void main(String[] args) {
        InvertedIndex index = new InvertedIndex();
        index.addDocument("doc1", Arrays.asList("hello", "world"));
        index.addDocument("doc2", Arrays.asList("world", "search"));
        index.addDocument("doc3", Arrays.asList("search", "engine"));

        List<Integer> results = index.search("hello world");
        System.out.println(results); // Output: [0]

        int doc1Count = index.getDocumentCount("doc1");
        System.out.println("Document count for doc1: " + doc1Count); // Output: 0
    }
}