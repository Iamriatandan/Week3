package linearsearch.searchword;

public class SearchWord {
    public static void main(String[] args) {

        //string of sentences
        String[] sentences = {"Welcome to the core edition to java" , "There is a black mouse" , "You can do it"};
        String wordToSearch = "black";

        String result = searchWord(sentences,wordToSearch);
        System.out.println("Word is : " + wordToSearch + " and its sentence is : " + result);
    }

    //method to find word and return its sentence
    public static String searchWord(String [] sentences ,String wordToSearch){
        for(String text : sentences){
            if(text.contains(wordToSearch)){
                return text;
            }
        }
        return "Not found";
    }
}
