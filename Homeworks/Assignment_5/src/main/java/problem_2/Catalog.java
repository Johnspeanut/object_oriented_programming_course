package problem_2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class presenting library catalog.
 * The itemCollection does not allow contain duplicated items.
 */
public class Catalog {
  private ArrayList<ILibrary> itemCollection = new ArrayList<ILibrary>();

  /**
   * Constructor for the Catalog class object with no parameter.
   */
  public Catalog() {
  }

  /**
   * Overload constructor for the Catalog class object with a parameter, which is the collection.
   * @param itemCollection The collection of items.
   */
  public Catalog(ArrayList<ILibrary> itemCollection) {
    this.itemCollection = itemCollection;
  }

  /**
   * Gets the collection of items
   * @return the collection of items.
   */
  public ArrayList<ILibrary> getItemCollection() {
    return itemCollection;
  }

  /**
   * Overload method to check if an item in the collection. Input is ILibrary.
   * @param item Ilibrary item to be checked.
   * @return true if the catalog contains the item.
   */
  public boolean contains(ILibrary item){
    if(itemCollection.isEmpty()){
      return false;
    }
    for(ILibrary element:this.itemCollection){
      if(element.equals(item)){
        return true;
      }
    }
    return false;
  }

  /**
   * Overload method to check if there is item with a specific title in the coolection.
   * Input is title.
   * @param title The title of book or music to be checked.
   * @return true if the catalog contains the item.
   */
  public boolean contains(String title){
    if(itemCollection.isEmpty()){
      return false;
    }
    for(ILibrary element:this.itemCollection){
      if(element.getTitle().equals(title)){
        return true;
      }
    }
    return false;
  }

  /**
   * Adds an item to the collection.
   * If there a duplicated item in the collection, cannot add it.
   * @param item the item to be added.
   * @return true if the adding is successful.
   */
  public boolean addItem(ILibrary item){
    if(!this.contains(item)){
      this.itemCollection.add(item);
      return true;
    }
    return false;
  }

  /**
   * removes an item from the catalog collection.
   * @param item The item to be removed.
   * @return true if removed successfully.
   */
  public boolean removeItem(ILibrary item){
    if(this.contains(item)){
      for(ILibrary element:this.itemCollection){
        if(element.equals(item)){
this.itemCollection.remove(element);
        }
      }
      return true;
    }else{
      throw new IllegalArgumentException("The item is not in the collection");
    }
  }

  /**
   * Update item based on Title.
   * @param item An item with new information to be updated
   * @return true if updated successfully.
   */
  public boolean updateItem(ILibrary item){
      for(ILibrary element:this.itemCollection){
        int i = 0;
        if(item.getTitle().equals(element.getTitle())){
          this.itemCollection.set(i,item);
          return true;
        }
        i++;
      }
      return false;
    }

  /**
   * Search items that have a keyword in their title.
   * @param keyword The keyword to be checked.
   * @return A list that includes items having the keyword in their titles.
   */
  public ArrayList<ILibrary> search(String keyword){
    ArrayList<ILibrary> newList = new ArrayList<ILibrary>();
    for(ILibrary element:this.itemCollection){
      if(element.search(keyword)){
        newList.add(element);
      }
    }
    return newList;
  }

  /**
   * Overload search method.
   * Search items that have the author.
   * @param author The author to be checked.
   * @return A list that includes items with the author.
   */
  public ArrayList<ILibrary> search(Author author){
    ArrayList<ILibrary> newList = new ArrayList<ILibrary>();
    for(ILibrary element:this.itemCollection){
      if(element.search(author)){
        newList.add(element);
      }
    }
    return newList;
  }

  /**
   * Overload search method.
   * Search items that have the artist.
   * @param artist The artist to be checked.
   * @return A list that includes items with the artist.
   */
  public ArrayList<ILibrary> search(RecordingArtist artist){
    ArrayList<ILibrary> newList = new ArrayList<ILibrary>();
    for(ILibrary element:this.itemCollection){
      if(element.search(artist)){
        newList.add(element);
      }
    }
    return newList;
  }

  /**
   * Override equals method.
   * @param o Object to be compared.
   * @return true if attributes are equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Catalog)) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    if(this.itemCollection.size() != catalog.getItemCollection().size()){
      return false;
    }
    for(int i = 0; i < this.itemCollection.size(); i++){
      if(!this.itemCollection.get(i).equals(catalog.itemCollection.get(i))){
        return false;
      }
    }
    return true;
  }

  /**
   * Override hashcode method.
   * @return true if hashcode are equals.
   */
  @Override
  public int hashCode() {
    return Objects.hash(itemCollection);
  }

  /**
   * Override toString method.
   * @return true if Strings are equal.
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "itemCollection=" + itemCollection +
        '}';
  }
}









