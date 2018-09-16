/*
 * Copyright (c) 2013-2018, Centre for Genomic Regulation (CRG).
 * Copyright (c) 2013-2018, Paolo Di Tommaso and the respective authors.
 *
 *   This file is part of 'Nextflow'.
 *
 *   Nextflow is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Nextflow is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Nextflow.  If not, see <http://www.gnu.org/licenses/>.
 */

package nextflow.ast

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassCodeExpressionTransformer
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.BinaryExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.Expression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.NotExpression
import org.codehaus.groovy.ast.tools.GeneralUtils
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
/**
 * Implements Nextflow Xform logic
 * See http://groovy-lang.org/metaprogramming.html#_classcodeexpressiontransformer
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@Slf4j
@CompileStatic
@GroovyASTTransformation(phase = CompilePhase.CONVERSION)
class NextflowXformImpl implements ASTTransformation {

    SourceUnit unit

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        this.unit = unit
        createVisitor().visitClass((ClassNode)nodes[1])
    }

    protected ClassCodeExpressionTransformer createVisitor() {

        new ClassCodeExpressionTransformer() {

            protected SourceUnit getSourceUnit() { unit }

            @Override
            Expression transform(Expression expr) {

                if( expr instanceof BinaryExpression ) {
                    def call = replaceBinaryWithEquals(expr)
                    if( call )
                        return call
                }

                super.transform(expr)
            }


            protected Expression replaceBinaryWithEquals(Expression expr) {

                if( !(expr instanceof BinaryExpression) )
                    return null

                final binary = expr as BinaryExpression
                final left = binary.getLeftExpression()
                final right = binary.getRightExpression()

                if( left instanceof ConstantExpression )
                    return callEquals(left,right)

                if( binary.operation.text == '==' ) {
                    return callEquals(left,right)
                }

                if( binary.operation.text == '!=' ) {
                    return new NotExpression(callEquals(left,right))
                }

                return null
            }


            private static MethodCallExpression callEquals(Expression left, Expression right) {
                GeneralUtils.callX(
                        GeneralUtils.classX(Hack),
                        'equals',
                        GeneralUtils.args(left,right))
            }
        }
    }

}
