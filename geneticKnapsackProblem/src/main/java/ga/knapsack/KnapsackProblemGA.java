package ga.knapsack;


import org.jgap.InvalidConfigurationException;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.BooleanGene;
import org.jgap.impl.DefaultConfiguration;

/**
 * Main class to call to GA Library.
 */
public class KnapsackProblemGA {

	/**
	 * Main method.
	 * Create a Configuration and Initial Genotype,
   * with the population size of configuration for JGAP Library.
	 * Evolve the problem.
	 * @param args Arguments for the main function.
	 */
public static void main(String[] args) throws InvalidConfigurationException {
    Configuration conf = new DefaultConfiguration();
    conf.setPreservFittestIndividual(true);
    conf.setKeepPopulationSizeConstant(false);

    KnapsackProblem myKnapsack = new KnapsackProblem(50);
    KnapsackFitness myFunc = new KnapsackFitness(myKnapsack);
    conf.setFitnessFunction(myFunc);

    int itemCount = myKnapsack.getItemCount();
    Gene[] genes = new Gene[itemCount];
    for (int i = 0; i < itemCount; i++) {
        genes[i] = new BooleanGene(conf);
    }

    Chromosome chromosome = new Chromosome(conf, genes);
    conf.setSampleChromosome(chromosome);
    conf.setPopulationSize(50);

    Genotype population = Genotype.randomInitialGenotype(conf);

    for (int i = 0; i < 100; i++) {
        population.evolve();
    }

    IChromosome best = population.getFittestChromosome();
    System.out.println("Mejor solución con valor: " + best.getFitnessValue());
    for (int i = 0; i < itemCount; i++) {
        System.out.println("Item " + i + " seleccionado: " + best.getGene(i).getAllele());
    }
}

}
