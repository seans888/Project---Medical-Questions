package project.pbl1;

import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String question;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a question:");
        question = scanner.nextLine();


        String parserModel = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
        LexicalizedParser lexicalizedParser = LexicalizedParser.loadModel(parserModel);


        TokenizerFactory<CoreLabel> tokenizerFactory
                = PTBTokenizer.factory(new CoreLabelTokenFactory(), " ");
        Tokenizer<CoreLabel> tokenizer
                = tokenizerFactory.getTokenizer(new StringReader(question));
        List<CoreLabel> wordList = tokenizer.tokenize();

        Tree parseTree = lexicalizedParser.apply(wordList);

        TreebankLanguagePack TreebankLanguagePack = lexicalizedParser.treebankLanguagePack();
        GrammaticalStructureFactory GrammaticalStructureFactory = TreebankLanguagePack.grammaticalStructureFactory();
        GrammaticalStructure GrammaticalStructure = GrammaticalStructureFactory.newGrammaticalStructure(parseTree);
        List<TypedDependency> tdl = GrammaticalStructure.typedDependenciesCCprocessed();
        System.out.println(tdl);

        
    }


}



