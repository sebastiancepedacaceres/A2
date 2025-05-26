package ga.knapsack;


import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 * This class is used for calculate the fitness value.
 *
 */
public class KnapsackFitness extends FitnessFunction {

  /**
   * reference to knapsack instance.
   */
  private KnapsackProblem myKnapsack;

  /**
   * KnapsackFitness constructor.
   * @param knapsack instance.
   */
  public KnapsackFitness(KnapsackProblem knapsack) {
    myKnapsack = knapsack;
  }

  /**
   * Implements the fitness function, how good is the chromosome I am evaluating.
   * @param chromosome Chromosome to evaluate
   * @return fitness value
   */
 @Override
  protected double evaluate(IChromosome chromosome) {
    int totalWeight = 0;
    int totalValue = 0;

    for (int i = 0; i < chromosome.size(); i++) {
        boolean isSelected = (Boolean) chromosome.getGene(i).getAllele();
        if (isSelected) {
            totalWeight += myKnapsack.getWeight(i);
            totalValue += myKnapsack.getValue(i);
        }
    }

    if (totalWeight > myKnapsack.getMaxCapacity()) {
        return 0; // Penaliza si excede
    }
    return totalValue;
  }

}
