package problem2_recursiveSet;

public interface ISet {
  

public boolean isEmpty();

public ISet add(Integer element);

public boolean contains(Integer element);

public ISet remove(Integer element);

public Integer size();

}
