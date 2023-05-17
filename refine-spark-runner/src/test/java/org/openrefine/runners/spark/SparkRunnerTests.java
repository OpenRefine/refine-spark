
package org.openrefine.runners.spark;

import java.io.Serializable;

import org.openrefine.model.Runner;
import org.openrefine.runners.testing.RunnerTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This runs the common test suite of all runners. Tests are added by inheritance, from {@link RunnerTestBase}
 * 
 * @author Antonin Delpeuch
 *
 */
public class SparkRunnerTests extends RunnerTestBase {

    @Override
    public Runner getDatamodelRunner() {
        return new SparkRunner(SparkBasedTest.context);
    }

    // Additional tests specific to the Spark implementation

    @Test
    public void testGridFromMemoryHasCachedRowCount() {
        SparkGrid grid = (SparkGrid) createGrid(new String[] { "foo" }, new Serializable[][] { { "bar" } });

        Assert.assertTrue(grid.isRowCountCached());
        Assert.assertEquals(grid.rowCount(), 1L);
    }

}
