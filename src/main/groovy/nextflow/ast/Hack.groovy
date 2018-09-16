package nextflow.ast

import java.nio.file.Path

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import nextflow.processor.TaskPath
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation

/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@PackageScope
@CompileStatic
class Hack {

    @PackageScope
    static boolean equals( Object o1, Object o2 )  {
        if( o1 instanceof Path && o2 instanceof Path ) {
            return TaskPath.equals(o1, o2)
        }

        DefaultTypeTransformation.compareEqual(o1,o2)
    }
    
}
