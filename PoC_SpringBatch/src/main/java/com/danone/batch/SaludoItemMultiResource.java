package com.danone.batch;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class SaludoItemMultiResource extends MultiResourceItemReader<String>
{
    private static final Logger logger = LoggerFactory.getLogger( SaludoItemMultiResource.class );

    private boolean failOnNoResources = true;
    public  boolean failOnNoResources () { return this.failOnNoResources; }
    public  void    setFailOnNoResources ( boolean failOnNoResources ) { this.failOnNoResources = failOnNoResources; }

    @Override
    public void setResources ( Resource[] resources )
    {
    	boolean noResources = (( resources == null ) || ( resources.length < 1 ));
System.out.println("noResources: "+noResources+" failOnNoResources(): "+failOnNoResources());
        if ( noResources && failOnNoResources())
        {
        	System.err.println("\n\t\tNo resources to read");
            throw new RuntimeException( "No resources to read" );
        }

        super.setResources( resources );

        logger.debug(String.format( "Resources set: %s", Arrays.toString( resources )));
        
    }
    
    @Override
    public Resource getCurrentResource() {
    	Resource resource = super.getCurrentResource();
    	System.err.println("Recurso: "+resource.getFilename());
    	return resource;
    }
	
    
    @Override
    public void open(ExecutionContext executionContext)
    		throws ItemStreamException {
    	System.err.println("Multiresource - open()..!!");
    	super.open(executionContext);
    }
    
    @Override
    protected void setExecutionContextName(String name) {
    	System.err.println("Multiresource - setExecutionContextName..!!");
    	super.setExecutionContextName(name);
    }
    
    @Override
    public void setDelegate(
    		ResourceAwareItemReaderItemStream<? extends String> delegate) {
    	System.err.println("Multiresource - setDelegate..!!");
    	super.setDelegate(delegate);
    }
    
    @Override
    public String read() throws Exception, UnexpectedInputException,
    		ParseException {
    	System.err.println("Multiresource - read()..!!");
    	return super.read();
    }
}
