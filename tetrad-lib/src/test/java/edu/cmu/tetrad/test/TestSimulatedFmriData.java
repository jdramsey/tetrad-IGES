///////////////////////////////////////////////////////////////////////////////
// For information as to what this class does, see the Javadoc, below.       //
// Copyright (C) 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006,       //
// 2007, 2008, 2009, 2010, 2014, 2015 by Peter Spirtes, Richard Scheines, Joseph   //
// Ramsey, and Clark Glymour.                                                //
//                                                                           //
// This program is free software; you can redistribute it and/or modify      //
// it under the terms of the GNU General Public License as published by      //
// the Free Software Foundation; either version 2 of the License, or         //
// (at your option) any later version.                                       //
//                                                                           //
// This program is distributed in the hope that it will be useful,           //
// but WITHOUT ANY WARRANTY; without even the implied warranty of            //
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the             //
// GNU General Public License for more details.                              //
//                                                                           //
// You should have received a copy of the GNU General Public License         //
// along with this program; if not, write to the Free Software               //
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA //
///////////////////////////////////////////////////////////////////////////////

package edu.cmu.tetrad.test;

import edu.cmu.tetrad.algcomparison.Comparison;
import edu.cmu.tetrad.algcomparison.algorithm.Algorithms;
import edu.cmu.tetrad.algcomparison.algorithm.multi.*;
import edu.cmu.tetrad.algcomparison.algorithm.oracle.pattern.Fges;
import edu.cmu.tetrad.algcomparison.algorithm.oracle.pattern.PcMax;
import edu.cmu.tetrad.algcomparison.independence.SemBicTest;
import edu.cmu.tetrad.algcomparison.simulation.LoadContinuousDataAndSingleGraph;
import edu.cmu.tetrad.algcomparison.simulation.Simulations;
import edu.cmu.tetrad.algcomparison.statistic.*;
import edu.cmu.tetrad.search.Lofs2;
import edu.cmu.tetrad.util.Parameters;

/**
 * Pulling this test out for Madelyn.
 *
 * @author jdramsey
 */
public class TestSimulatedFmriData {

    public void TestCycles_Data_fMRI_FANG() {
        Parameters parameters = new Parameters();

        parameters.set("penaltyDiscount", 6);
        parameters.set("depth", -1);
        parameters.set("maxCoef", 0.6);

        parameters.set("numRuns", 10);

        // For automatically generated concatenations if you're doing them.
        parameters.set("randomSelectionSize", 10);

        parameters.set("Structure", "Placeholder");

        Statistics statistics = new Statistics();

        statistics.add(new ParameterColumn("Structure"));
        statistics.add(new AdjacencyPrecision());
        statistics.add(new AdjacencyRecall());
        statistics.add(new ArrowheadPrecision());
        statistics.add(new ArrowheadRecall());
        statistics.add(new TwoCyclePrecision());
        statistics.add(new TwoCycleRecall());
        statistics.add(new TwoCycleFalsePositive2());
        statistics.add(new TwoCycleFalseNegative2());
        statistics.add(new TwoCycleTruePositive());
        statistics.add(new ElapsedTime());

        statistics.setWeight("AP", 1.0);
        statistics.setWeight("AR", 1.0);
        statistics.setWeight("AHP", 1.0);
        statistics.setWeight("AHR", 1.0);
        statistics.setWeight("2CP", 1.0);
        statistics.setWeight("2CR", 1.0);
        statistics.setWeight("2CFP", 1.0);

        Simulations simulations = new Simulations();

        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network1_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network2_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network3_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network4_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network5_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network5_contr"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network5_contr_p2n6"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network5_contr_p6n2"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network6_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network6_contr"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network7_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network7_contr"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network8_amp_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network8_amp_contr"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network8_contr_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network9_amp_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network9_amp_contr"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Network9_contr_amp"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Diamond"));
        simulations.add(new LoadContinuousDataAndSingleGraph(
                "/Users/jdramsey/Downloads/Cycles_Data_fMRI/Markov_Complex_1"));

        Algorithms algorithms = new Algorithms();

        algorithms.add(new Fges(new edu.cmu.tetrad.algcomparison.score.SemBicScore(), true));
        algorithms.add(new PcMax(new SemBicTest(), true));
        algorithms.add(new Fang());
        algorithms.add(new FasLofs(Lofs2.Rule.R1));
        algorithms.add(new FasLofs(Lofs2.Rule.R2));
        algorithms.add(new FasLofs(Lofs2.Rule.R3));
        algorithms.add(new FasLofs(Lofs2.Rule.Patel));
        algorithms.add(new FasLofs(Lofs2.Rule.Skew));
        algorithms.add(new FasLofs(Lofs2.Rule.RSkew));

//        algorithms.add(new FgesConcatenated(new edu.cmu.tetrad.algcomparison.score.SemBicScore(), true));
//        algorithms.add(new PcMaxConcatenated(new SemBicTest(), true));
//        algorithms.add(new FangConcatenated());
//        algorithms.add(new FasLofsConcatenated(Lofs2.Rule.R1));
//        algorithms.add(new FasLofsConcatenated(Lofs2.Rule.R2));
//        algorithms.add(new FasLofsConcatenated(Lofs2.Rule.R3));
//        algorithms.add(new FasLofsConcatenated(Lofs2.Rule.Patel));
//        algorithms.add(new FasLofsConcatenated(Lofs2.Rule.EB));
//        algorithms.add(new FasLofsConcatenated(Lofs2.Rule.Skew));
//        algorithms.add(new FasLofsConcatenated(Lofs2.Rule.RSkew));
//

        Comparison comparison = new Comparison();

        comparison.setShowAlgorithmIndices(true);
        comparison.setShowSimulationIndices(true);
        comparison.setSortByUtility(false);
        comparison.setShowUtilities(false);
        comparison.setParallelized(false);
        comparison.setSaveGraphs(false);
        comparison.setTabDelimitedTables(false);

        comparison.compareFromSimulations("comparison", simulations, algorithms, statistics, parameters);
    }

    public static void main(String... args) {
        new TestSimulatedFmriData().TestCycles_Data_fMRI_FANG();
    }
}




