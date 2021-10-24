package edu.odu.cs.cs350;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class TestMagazine {
    @Test
    public void testDefaultConstructor() {
        Magazine m = new Magazine();
        assertThat(m.getTitle(), isEmptyString());
        LocalDate date = LocalDate.now();
        assertTrue(m.getPublicationDate().equals(date));
        Article a = m.getArticle(1);
        assertNull(a);
        assertThat(m.numArticles(), is(0));
    }

     @Test
     public void testConstructorWithParams() {
        LocalDate date = LocalDate.of(2000, 1, 1);
        String title = "Millenium";
        Magazine m = new Magazine(title, date);
        assertTrue(m.getTitle().equals(title));
        assertTrue(m.getPublicationDate().equals(date));
        Article a = m.getArticle(1);
        assertNull(a);
        assertThat(m.numArticles(), is(0));
    }

    @Test
    public void testSetTitle() {
        Magazine m = new Magazine();
        String title = "Millenium";
        m.setTitle(title);
        assertEquals(title, m.getTitle());
        assertEquals(LocalDate.now(), m.getPublicationDate());
        Article a = m.getArticle(1);
        assertNull(a);
        assertThat(m.numArticles(), is(0));
    }

    @Test
    public void testSetPubDate() {
        Magazine m = new Magazine();
        LocalDate date = LocalDate.of(2000, 1, 1);
        m.setPublicationDate(date);
        assertEquals(date, m.getPublicationDate());
        assertEquals("", m.getTitle());
        Article a = m.getArticle(1);
        assertNull(a);
        assertThat(m.numArticles(), is(0));
    }

    @Test
    public void testAddArticles() {
        LocalDate date = LocalDate.of(2000, 1, 1);
        String title = "Millenium";
        Magazine m = new Magazine(title, date);

        Article a = new Article("aTitle", "aAuthor");
        m.addArticle(1, a);
        assertEquals(a, m.getArticle(1));
        assertThat(m.numArticles(), is(1));
        assertTrue(m.getTitle().equals(title));
        assertTrue(m.getPublicationDate().equals(date));
        assertThat(m.startingPages(), hasItem(1));

        Article b = new Article("bTitle", "bAuthor");
        m.addArticle(1, b);
        assertEquals(b, m.getArticle(1));
        assertThat(m.numArticles(), is(1));
        assertThat(m.startingPages(), hasItem(1));
        m.addArticle(2,a);
        assertEquals(a, m.getArticle(2));
        assertThat(m.numArticles(), is(2));
        assertThat(m.startingPages(), hasItem(2));
        Article c = new Article("cTitle", "cAuthor");
        m.addArticle(200, c);
        assertEquals(c, m.getArticle(200));
        assertThat(m.numArticles(), is(3));
        assertThat(m.startingPages(), hasItem(200));

        for(Integer page: m.startingPages()){
            Article art = m.getArticle(page);
            switch(page) {
                case 1: assertEquals(b, art);
                        break;
                case 2: assertEquals(a, art);
                        break;
                case 200: assertEquals(c, art);
                        break;
            }
        }
    }

    @Test
    public void testToString() {
        LocalDate date = LocalDate.of(2000, 1, 1);
        String title = "Millenium";
        Magazine m = new Magazine(title, date);
        String s = m.toString();
        assertThat(s, allOf(containsString(title), containsString(date.toString())));
    }

    @Test
    public void testEqualsAndHashcode() {
        Magazine m = new Magazine();
        Magazine n = new Magazine();
        assertTrue(m.equals(n));
        String title = "a";
        m.setTitle(title);
        assertNotEquals(m, n);
        n.setTitle(title);
        assertEquals(m,n);
        assertEquals(m.hashCode(), n.hashCode());

        LocalDate date = LocalDate.of(2000,1,1);
        m.setPublicationDate(date);
        assertNotEquals(m, n);
        n.setPublicationDate(date);
        assertEquals(m,n);
        assertEquals(m.hashCode(), n.hashCode());

        Article a = new Article("aTitle", "aAuthor");
        m.addArticle(1, a);
        assertNotEquals(m,n);
        n.addArticle(1,a);
        assertEquals(m,n);
        assertEquals(m.hashCode(), n.hashCode());

        Article b = new Article("bTitle", "bAuthor");
        Article c = new Article("cTitle", "cAuthor");
        m.addArticle(2, b);
        n.addArticle(3, c);
        assertNotEquals(m,n);
        m.addArticle(3,c);
        n.addArticle(4,b);
        assertNotEquals(m,n);
    }

    @Test
    public void testClone() {
        Magazine m = new Magazine("a", LocalDate.now());
        Article b = new Article("bTitle", "bAuthor");
        Article c = new Article("cTitle", "cAuthor");
        m.addArticle(1, b);
        m.addArticle(2, c);
        Magazine n = (Magazine)m.clone();
        assertEquals(m,n);

        m.addArticle(3, b);
        assertNotEquals(m,n);
        n.addArticle(3, b);
        m.setTitle("d");
        assertNotEquals(m,n);
        n.setTitle("d");
        LocalDate d = LocalDate.of(2000,1,1);
        m.setPublicationDate(d);
        assertNotEquals(m,n);

    } 
}