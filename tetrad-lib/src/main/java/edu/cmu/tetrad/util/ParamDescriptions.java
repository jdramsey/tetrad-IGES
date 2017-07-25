package edu.cmu.tetrad.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores descriptions of the parameters for the simulation box. All parameters
 * that go into the interface need to be described here.
 *
 * @author jdramsey
 */
public class ParamDescriptions {

    private static ParamDescriptions instance = new ParamDescriptions();
    private Map<String, ParamDescription> map = new HashMap<>();

    public ParamDescriptions() {
        put("numMeasures", new ParamDescription("Number of measured variables (min = 1)", 10, 1, Integer.MAX_VALUE));
        put("numLatents", new ParamDescription("Number of latent variables (min = 0)", 0, 0, Integer.MAX_VALUE));
        put("avgDegree", new ParamDescription("Average degree of graph (min = 1)", 2, 1, Integer.MAX_VALUE));
        put("maxDegree", new ParamDescription("The maximum degree of the graph (min = -1)", 100, -1, Integer.MAX_VALUE));
        put("maxIndegree", new ParamDescription("Maximum indegree of graph (min = 1)", 100, 1, Integer.MAX_VALUE));
        put("maxOutdegree", new ParamDescription("Maximum outdegree of graph (min = 1)", 100, 1, Integer.MAX_VALUE));
        put("connected", new ParamDescription("Yes if graph should be connected", false));
        put("sampleSize", new ParamDescription("Sample size (min = 1)", 1000, 1, Integer.MAX_VALUE));
        put("numRuns", new ParamDescription("Number of runs (min = 1)", 1, 1, Integer.MAX_VALUE));
        put("differentGraphs", new ParamDescription("Yes if a different graph should be used for each run", false));
        put("alpha", new ParamDescription("Cutoff for p values (alpha) (min = 0.0)", 0.01, 0.0, 1.0));
        put("penaltyDiscount", new ParamDescription("Penalty discount (min = 0.0)", 2.0, 0.0, Double.MAX_VALUE));
        put("fgesDepth", new ParamDescription("Maximum number of new colliders (min = 1)", 1, 1, Integer.MAX_VALUE));
        put("standardize", new ParamDescription("Yes if the data should be standardized", false));
        put("measurementVariance", new ParamDescription("Additive measurement noise variance (min = 0.0)", 0.0, 0.0, Double.MAX_VALUE));
        put("depth", new ParamDescription("Maximum size of conditioning set (min = -1)", -1, -1, Integer.MAX_VALUE));
        put("coefLow", new ParamDescription("Low end of coefficient range (min = 0.0)", 0.5, 0.0, Double.MAX_VALUE));
        put("coefHigh", new ParamDescription("High end of coefficient range (min = 0.0)", 1.5, 0.0, Double.MAX_VALUE));
        put("covLow", new ParamDescription("Low end of covariance range (min = 0.0)", 0.5, 0.0, Double.MAX_VALUE));
        put("covHigh", new ParamDescription("High end of covariance range (min = 0.0)", 1.5, 0.0, Double.MAX_VALUE));
        put("varLow", new ParamDescription("Low end of variance range (min = 0.0)", 1.0, 0.0, Double.MAX_VALUE));
        put("varHigh", new ParamDescription("High end of variance range (min = 0.0)", 3.0, 0.0, Double.MAX_VALUE));
        put("printWinners", new ParamDescription("Yes if winning models should be printed", false));
        put("printAverages", new ParamDescription("Yes if averages should be printed", false));
        put("printAverageTables", new ParamDescription("Yes if average tables should be printed", true));
        put("printGraphs", new ParamDescription("Yes if graphs should be printed", false));
        put("dataType", new ParamDescription("Categorical or discrete", "categorical"));
        put("percentDiscrete", new ParamDescription("Percentage of discrete variables (0 - 100) for mixed data", 0.0, 0.0, 100.0));
        put("ofInterestCutoff", new ParamDescription("Cutoff for graphs considered to be of interest (min = 0.0)", 0.05, 0.0, 1.0));
        put("numCategories", new ParamDescription("Number of categories for discrete variables (min = 2)", 4, 2, Integer.MAX_VALUE));
        put("minCategories", new ParamDescription("Minimum number of categories (min = 2)", 2, 2, Integer.MAX_VALUE));
        put("maxCategories", new ParamDescription("Maximum number of categories (min = 2)", 2, 2, Integer.MAX_VALUE));
        put("samplePrior", new ParamDescription("Sample prior (min = 1.0)", 1.0, 1.0, Double.MAX_VALUE));
        put("structurePrior", new ParamDescription("Structure prior coefficient (min = 1.0)", 1.0, 1.0, Double.MAX_VALUE));
        put("mgmParam1", new ParamDescription("MGM tuning parameter #1 (min = 0.0)", 0.1, 0.0, Double.MAX_VALUE));
        put("mgmParam2", new ParamDescription("MGM tuning parameter #2 (min = 0.0)", 0.1, 0.0, Double.MAX_VALUE));
        put("mgmParam3", new ParamDescription("MGM tuning parameter #3 (min = 0.0)", 0.1, 0.0, Double.MAX_VALUE));
        put("scaleFreeAlpha", new ParamDescription("For scale-free graphs, the parameter alpha (min = 0.0)", 0.05, 0.0, 1.0));
        put("scaleFreeBeta", new ParamDescription("For scale-free graphs, the parameter beta (min = 0.0)", 0.9, 0.0, 1.0));
        put("scaleFreeDeltaIn", new ParamDescription("For scale-free graphs, the parameter delta_in (min = 0.0)", 3, 0.0, Double.MAX_VALUE));
        put("scaleFreeDeltaOut", new ParamDescription("For scale-free graphs, the parameter delta_out (min = 0.0)", 3, 0.0, Double.MAX_VALUE));
        put("generalSemFunctionTemplateMeasured", new ParamDescription("General function template for measured variables", "TSUM(NEW(B)*$)"));
        put("generalSemFunctionTemplateLatent", new ParamDescription("General function template for latent variables", "TSUM(NEW(B)*$)"));
        put("generalSemErrorTemplate", new ParamDescription("General function for error terms", "Beta(2, 5)"));
        put("coefSymmetric", new ParamDescription("Yes if negative coefficient values should be considered", true));
        put("covSymmetric", new ParamDescription("Yes if negative covariance values should be considered", true));
        put("retainPreviousValues", new ParamDescription("Retain previous values", false));

        // Boolean Glass parameters.
        put("lagGraphVarsPerInd", new ParamDescription("Number of variables per individual (min = 1)", 5, 1, Integer.MAX_VALUE));
        put("lagGraphMlag", new ParamDescription("Maximum lag of graph (min = 1)", 1, 1, Integer.MAX_VALUE));
        put("lagGraphIndegree", new ParamDescription("Indegree of graph (min = 1)", 2, 1, Integer.MAX_VALUE));
        put("numDishes", new ParamDescription("Number of dishes (min = 1)", 1, 1, Integer.MAX_VALUE));
        put("numCellsPerDish", new ParamDescription("Number of cells per dish (min = 1)", 10000, 1, Integer.MAX_VALUE));
        put("stepsGenerated", new ParamDescription("Number of steps generated (min = 1)", 4, 1, Integer.MAX_VALUE));
        put("firstStepStored", new ParamDescription("The index of the first step stored (min = 1)", 1, 1, Integer.MAX_VALUE));
        put("interval", new ParamDescription("The interval between steps stored (min = 1)", 1, 1, Integer.MAX_VALUE));
        put("rawDataSaved", new ParamDescription("Yes if the raw data should be saved (otherwise tossed)", false));
        put("measuredDataSaved", new ParamDescription("Yes if the measured data should be saved (otherwise tossed)", true));
        put("initSync", new ParamDescription("Yes if cells should be initialized synchronously, otherwise randomly", true));
        put("antilogCalculated", new ParamDescription("Yes if antilogs of data should be calculated", false));
        put("dishDishVariability", new ParamDescription("Dish to dish variability (min = 0.0)", 10.0, 0.0, Double.MAX_VALUE));
        put("numChipsPerDish", new ParamDescription("Number of chips per dish (min = 1)", 4, 1, Integer.MAX_VALUE));
        put("sampleSampleVariability", new ParamDescription("Sample to sample variability (min = 0.0)", 0.025, 0.0, Double.MAX_VALUE));
        put("chipChipVariability", new ParamDescription("Chip to chip variability (min = 0.0)", 0.1, 0.0, Double.MAX_VALUE));
        put("pixelDigitalization", new ParamDescription("Pixel digitalization (min = 0.0)", 0.025, 0.0, Double.MAX_VALUE));
        put("includeDishAndChipColumns", new ParamDescription("Yes if Dish and Chip columns should be included in output", true));

        put("numRuns", new ParamDescription("The number runs", 1));
        put("randomSelectionSize", new ParamDescription("The number of datasets that should be taken in each random sample", 1));

        put("maxit", new ParamDescription("MAXIT parameter (GLASSO) (min = 1)", 10000, 1, Integer.MAX_VALUE));
        put("ia", new ParamDescription("IA parameter (GLASSO)", false));
        put("is", new ParamDescription("IS parameter (GLASSO)", false));
        put("itr", new ParamDescription("ITR parameter (GLASSO)", false));
        put("ipen", new ParamDescription("IPEN parameter (GLASSO)", false));
        put("thr", new ParamDescription("THR parameter (GLASSO) (min = 0.0)", 1e-4, 0.0, Double.MAX_VALUE));

        put("targetName", new ParamDescription("Target name", ""));
        put("verbose", new ParamDescription("Yes if verbose output should be printed or logged", false));
        put("faithfulnessAssumed", new ParamDescription("Yes if (one edge) faithfulness should be assumed", false));

        put("useWishart", new ParamDescription("Yes if the Wishart test shoud be used. No if the Delta test should be used", false));
        put("useGap", new ParamDescription("Yes if the GAP algorithms should be used. No if the SAG algorithm should be used", false));

        // Multiple indicator random graphs
        put("numStructuralNodes", new ParamDescription("Number of structural nodes", 3));
        put("numStructuralEdges", new ParamDescription("Number of structural edges", 3));
        put("measurementModelDegree", new ParamDescription("Number of measurements per Latent", 5));
        put("latentMeasuredImpureParents", new ParamDescription("Number of Latent --> Measured impure edges", 0));
        put("measuredMeasuredImpureParents", new ParamDescription("Number of Measured --> Measured impure edges", 0));
        put("measuredMeasuredImpureAssociations", new ParamDescription("Number of Measured <-> Measured impure edges", 0));

//        put("useRuleC", new ParamDescription("Yes if rule C for CCD should be used", false));
        put("applyR1", new ParamDescription("Yes if the orient away from arrow rule should be applied", true));
        put("probCycle", new ParamDescription("The probability of adding a cycle to the graph", 1.0, 0.0, 1.0));
        put("intervalBetweenShocks", new ParamDescription("Interval beween shocks (R. A. Fisher simulation model) (min = 1)", 10, 1, Integer.MAX_VALUE));
        put("intervalBetweenRecordings", new ParamDescription("Interval between data recordings for the linear Fisher model (min = 1)", 10, 1, Integer.MAX_VALUE));

        put("skipNumRecords", new ParamDescription("Number of records that should be skipped between recordings (min = 0)", 0, 0, Integer.MAX_VALUE));
        put("fisherEpsilon", new ParamDescription("Epsilon where |xi.t - xi.t-1| < epsilon, criterion for convergence", .001, Double.MIN_VALUE, Double.MAX_VALUE));

        put("useMaxPOrientationHeuristic", new ParamDescription(
                "Yes if the heuristic for orienting unshielded colliders for max P should be used",
                true));
        put("maxPOrientationMaxPathLength", new ParamDescription("Maximum path length for the unshielded collider heuristic for max P (min = 0)", 3, 0, Integer.MAX_VALUE));
        put("orientTowardDConnections", new ParamDescription(
                "Yes if Richardson's step C (orient toward d-connection) should be used",
                true));
        put("orientVisibleFeedbackLoops", new ParamDescription(
                "Yes if visible feedback loops should be oriented",
                true));
        put("doColliderOrientation", new ParamDescription(
                "Yes if unshielded collider orientation should be done",
                true));

        put("completeRuleSetUsed", new ParamDescription(
                "Yes if the complete FCI rule set should be used",
                false));

        put("maxDistinctValuesDiscrete", new ParamDescription("The maximum number of distinct values in a column for discrete variables (min = 0)", 0, 0, Integer.MAX_VALUE));

        put("ngAlpha", new ParamDescription("Alpha for testing non-Gaussianity (min = 0.0)", 0.05, 0.0, 1.0));

        put("twoCycleAlpha", new ParamDescription("Alpha orienting 2-cycles (min = 0.0)", 1e-6, 0.0, 1.0));

        put("symmetricFirstStep", new ParamDescription("Yes if the first step step for FGES should do scoring for both X->Y and Y->X", false));

        put("discretize", new ParamDescription(
                "Yes if continuous variables should be discretized when child is discrete",
                true));

        put("determinismThreshold", new ParamDescription("Threshold for judging a regression of a variable onto its parents to be deternimistic (min = 0.0)", 0.1, 0.0, Double.POSITIVE_INFINITY));

        put("cgExact", new ParamDescription(
                "Yes if the exact algorithm should be used for continuous parents and discrete children",
                false));

        put("numCategoriesToDiscretize", new ParamDescription(
                "The number of categories used to discretize continuous variables, if necessary (min = 2)", 3, 2, Integer.MAX_VALUE));

        put("maxPathLength", new ParamDescription("The maximum length for any discriminating path. -1 if unlimited (min = -1)", -1, -1, Integer.MAX_VALUE));

        put("thresholdForReversing", new ParamDescription("Variables with skewnesses less than this value will be reversed in sign (min = 0)", 0.0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));

        // Bootstrapping
        put("bootstrapSampleSize", new ParamDescription("The number of bootstraps (min = 1)", 10, 1, Integer.MAX_VALUE));
        put("bootstrapEnsemble", new ParamDescription("Ensemble method: Preserved (0), Highest (1), Majority (2)", 1, 0, 2));

    }

    public static ParamDescriptions instance() {
        return instance;
    }

    public ParamDescription get(String name) {
        if (!map.containsKey(name)) {
            return new ParamDescription("Please add a description to ParamDescriptions for " + name, 0);
//            throw new IllegalArgumentException("Expecting a default value for " + name);
        }

        return map.get(name);
    }

    public void put(String name, ParamDescription paramDescription) {
        map.put(name, paramDescription);
    }
}
