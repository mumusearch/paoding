package net.paoding.analysis.analyzer;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import junit.framework.TestCase;

public class PaodingAnalyzerTest extends TestCase{

	static PaodingAnalyzer analyzer=new PaodingAnalyzer();
	
	public static void testPaodingAnalyzer() throws IOException{
	   TokenStream tokenStream = analyzer.tokenStream("", new StringReader("中华人民共和国万岁"))	;
	   tokenStream.reset();
	   
	   CharTermAttribute termAttr = tokenStream.addAttribute(CharTermAttribute.class);
	   
	   while(tokenStream.incrementToken()){
		   String term = termAttr.toString();
		   
		   System.out.println(term);
	   }
	   analyzer.close();
	}
}
