package edu.odu.cs.cs350;

import java.time.LocalDate;
import java.util.Set;


/**
 * A magazine containing a collection of articles, organized by (starting) page number.
 * 
 * 
 * @author zeil
 *
 */
public class Magazine implements Cloneable {

  

  /**
   * Create a "blank" magazine with empty strings for title, the current
   * date for the publication date,
   * and an empty (zero-length) list of articles.
   */
  public Magazine() {
  }

  /**
   * Create a new magazine.
   * @param title title of the magazine
   * @param publDate publication date of the magazine.
   */
  public Magazine(String title, LocalDate pubDate) {
  }

  
  
  /**
   * Get the title of this magazine.
   * @return the title
   */
  public String getTitle() {
    return "";
  }

  /**
   * Set the title of this magazine.
   * @param title the title to set
   */
  public void setTitle(String title) {
  }


  /**
   * Get the publication date of this magazine.
   * @return the date
   */
  public LocalDate getPublicationDate() {
    return null;
  }

  /**
   * Set the publication date of this magazine.
   * @param pubDate the publication date to set
   */
  public void setPublicationDate(LocalDate pubDate) {
  }

  
  /**
   * How many articles does this magazine have?
   * @return number of articles
   */
  public int numArticles() {
    return 0;
  }
  
  
  /**
   * Add an article to the magazine at an indicated starting page.
   * 
   * If an article is already at that page, replaces the existing one.
   * 
   * @param startingPage first page of the article
   * @param article author to be added
   */
  public void addArticle(int startingPage, Article article) {
  }
  
  /**
   * Get the article previously placed at a given starting page.
   * 
   * @param startingAtPage a page number in the magazine
   * @return the article starting at that page, or null if no article
   *     has been put there.
   */
  public Article getArticle (int startingAtPage) {
      return null;
  }
  
  
  /**
   * Render the magazine as a string in a format guaranteed to
   * contain all fields.
   */
  public String toString() {
    return "";
  }
  
  

  // Comparison and hashing

  /**
   * Compares two magazines for equality. They are considered equal if
   * all functions on them return equal results..
   *
   * @param obj object to be compared for equality with this magazine
   * @return <tt>true</tt> if the specified object is equal to this one
   */
  public boolean equals(Object obj) {
    return true;
  }

  /**
   * Returns the hash code value for this object.
   *
   * @return the hash code value for this magazine
   */
  public int hashCode() {
    return 0;
  }

  /**
   * Return a (deep) copy of this object.
   */
  @Override
  public Object clone()  {
    return this;
  }

  /**
   * Provide access to the table of contents of
   * this magazine. e.g.,
   *     Magazine magazine = new Magazine(...);
   *        ...
   *     for (Integer page: magazine,startingPages()) {
   *        Article art = magazine.getArticle(page);
   *        doSomethingWith (page, art);
   *     }
   * 
   * @return iterator over the starting page numbers. Numbers
   *        are returned in ascending order.
   */
  public Set<Integer> startingPages() {
    return null;
  }


}
