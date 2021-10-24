/**
 * 
 */
package edu.odu.cs.cs350;

/**
 * An article within a magazine.  An article has a title and an author name.
 * 
 * @author zeil
 *
 */
public class Article implements Cloneable {

  /**
   * The title of this article.
   */
  private String title;
  
  /**
   * The author of this article.
   */
  private String author;
  
  /**
   * Create an article.
   * @param title  the title of the article
   * @param author the name of the author
   */
  public Article (String title, String author) {
    this.title = title;
    this.author = author;
  }
  
  /**
   * Compare two articles for equality.
   * 
   * @param obj another author
   * @return true ff they have the same name
   */
  public boolean equals(Object obj) {
    if (obj instanceof Article) {
      Article au = (Article) obj;
      return author.equals(au.author)
          && title.equals(au.title);
    } else {
      return false;
    }
  }
  
  /**
   * Return a description of the article.
   *    givenName surname
   */
  public String toString() {
    return '"' + title  + '"' + " by " + author;
  }
  
  /**
   * Hash function for articles.
   */
  public int hashCode() {
      return title.hashCode() * 13 + author.hashCode();
  }
  
  /**
   * Return the surname of this author
   * @return the surname
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * Return the given name of this author 
   * @return the given name
   */
  public String getGivenName() {
    return author;
  }
  
  
  public Object clone() {
      return new Article(title, author);
  }
  

}
