package eu.excitementproject.eop.lap.textpro;

import static org.junit.Assert.fail;

import org.apache.uima.jcas.JCas;
import org.junit.Test;

import eu.excitementproject.eop.lap.LAPAccess;
import eu.excitementproject.eop.lap.LAPException;
import eu.excitementproject.eop.lap.PlatformCASProber;

public class TextProTaggerITTest {

	@Test
	public void test() {				
		
		LAPAccess lap = null;
		JCas aJCas = null;
		
		try {
			lap = new TextProTaggerIT();

			// one of the LAPAccess interface: that generates single TH CAS. 
			aJCas = lap.generateSingleTHPairCAS("Claude Chabrol e stato un regista, sceneggiatore e attore francese.","Le Beau Serge e stato diretto da Chabrol.");

			// probeCas check whether or not the CAS has all needed "Entailment" information. 
			// If it does not, it raises an LAPException. 
			// It will also print the summarized data of the CAS to the PrintStream. 
			// If the second argument is null, it will only check the format and raise Exceptions, without printing 
			PlatformCASProber.probeCas(aJCas, System.out); 
			
			// To see the full content of each View, use this 
			PlatformCASProber.probeCasAndPrintContent(aJCas, System.out); 
						
		} catch (LAPException e) {
			fail(e.getMessage());
		}
	}
	
}
