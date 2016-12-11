
QANUS v29Nov2012
-----------------------

The latest version of QANUS and this documentation can always be downloaded from
	http://junbin.com/qanus

QANUS is distributed under the Open Software License (OSL) v3.0.  
Please see the file "OSL v3.0.txt". For any enquiries, please feel free
to contact the author :

	NG, Jun Ping
	junping@comp.nus.edu.sg
	http://www.comp.nus.edu.sg/~junping
	
	AS6-04-13
	COM1, 13 Computing Drive
	National University of Singapore
	Singapore 117417
	SINGAPORE


Files
=======================================
demo-data     Contains a sample news article and same questions to run QANUS with
dist          JAR distributable files
src           Source files of QANUS
OSL v3.0.txt  Open Software License
README.txt    This readme file


Running a simple demo
=======================================

1. Extract the QANUS package into a folder (ie. <QANUS>)

2. Make the dist folder the current working directory
	ie. cd <QANUS>/dist

3. Run the information base builder
	ie. java -Xmx1g -classpath QANUS.jar sg.edu.nus.wing.qanus.stock.ibp.Controller --src ..\demo-data\data --tgt ..\temp

4. Run the question processor
	ie. java -Xmx1g -classpath QANUS.jar sg.edu.nus.wing.qanus.stock.qp.Controller --src ..\demo-data\questions --tgt ..\questions-anon

5. Run the answer retrieval
	ie. java -Xmx1g -classpath QANUS.jar sg.edu.nus.wing.qanus.stock.ar.Controller --kbsrc ..\temp\Lucene-Index --qnsrc ..\questions-anon --anstgt ..\
	
6. Run the evaluation module 
    - Take note the change "answers.xml" below to the generated answer file in step 5 above
	ie. java -Xmx1g -classpath QANUS.jar sg.edu.nus.wing.qanus.stock.eval.Controller --gen ..\answers.xml --correct ..\demo-data\data\demo-answers.xml --ans ..\

7. Answers can be found in the <QANUS> folder in a XML file named answers-<DATE>.xml, where <DATE> is the current data and time.



Usage notes for QANUS
=======================================

Please refer to the documentation on the architecture of QANUS
for more detailed information on the system.

This file is a quick reminder to ways to run QANUS.


1. Information Base Building 
================================================================================
java -Xmx1g -classpath QANUS.jar sg.edu.nus.wing.qanus.stock.ibp.Controller -src <source-folder> -tgt <tgt-folder>

where 

<source-folder> is the folder where input source XML documents are stored. If you are using the AQUAINT-2 corpus for example,
           this would be the root folder of the corpus.
		   
<tgt-folder> is the folder where the eventual knowledge base will be stored. If you are using the Lucene engine, this would
            be where the generated Lucene index is written to.
			


2. Question Processing
================================================================================
java -Xmx1g -classpath QANUS.jar sg.edu.nus.wing.qanus.stock.qp.Controller -src <source-folder> -tgt <tgt-folder>

where 

<source-folder> is the folder where input question XML documents are stored. If you are using the TREC-2007 QA track questions
           for example, this would be the folder containing the XML files.
		   
<tgt-folder> is the folder where the annotated questions will be stored. 


3. Answer Retrieval
================================================================================
java -Xmx1g -classpath QANUS.jar sg.edu.nus.wing.qanus.stock.ar.Controller -kbsrc <kb-source-folder> -qnsrc <qn-source-folder> -anstgt <tgt-folder>

where

<kb-source-folder> is the folder where the knowledge base built in the KBB stage is stored. If you chose to use a Lucene
		   index as the knowledge base, this would be the folder containing the index.
		   
<qn-source-folder> is the folder where the annotated questions from the QP stage are stored.

<tgt-folder> is the folder where you want the generated answers to be stored.


4. Evaluation
================================================================================
java -Xmx1g -classpath QANUS.jar sg.edu.nus.wing.qanus.stock.eval.Controller -gen <generated-answer-file> -correct <correct-answer-file> -ans <tgt-folder>

where

<generated-answer-file> is the file which contains the answers produced by the answer retrieval stage.
		   
<correct-answer-file> is the file which contains the "gold-standard" answers to cross-check the generated answers with.

<tgt-folder> is the folder where you want the evaluation results to be stored.



Important Usage Notes
=======================================

Due to licensing issues, we do not ship any corpora with QANUS. The information base building modules in QANUS are written to work with the XML format 
used in the AQUAINT-2 corpus. If you have access to this corpus, you can run QANUS with it immediately. Otherwise you would
have to work on a SAX-based XML handler to allow QANUS to understand the corpus you wish to use. More information about how you
can do this is found in the architecture documentation.

The various text processing modules included in QANUS make use of the work by the Stanford NLP group (http://nlp.stanford.edu). 
They are provided as a matter of convenience, and you are encouraged to refer to the Stanford NLP group for more information 
on these modules.

Other libraries used include:

Lucene - http://lucene.apache.org/
JOpt Simple - http://jopt-simple.sourceforge.net/
JSON Lib - http://json-lib.sourceforge.net/
Search Engine Wrapper (TAN, Yee Fan) - http://wing.comp.nus.edu.sg/~tanyeefa/downloads/searchenginewrapper/
Apache Commons - http://commons.apache.org/index.html
JAX-RPC - https://jax-rpc.dev.java.net/

