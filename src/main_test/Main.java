package main_test;

import models.AcceptedArticle;
import models.Authorship;
import models.Critique;
import models.Edition;
import models.Journal;
import models.JournalEditor;
import models.Review;
import models.Submission;
import models.User;
import models.Volume;

public class Main {
	public static void main(String[] args) {
		
		// USER TEST
		User user = new User();
		user.setEmail("alex@gmail.com");
		user.setForenames("Alex Ioana");
		user.setSurname("Herghelegiu");
		user.setUniversity("The University of Sheffield");
		System.out.println(user);
		
		System.out.println();
		// JOURNAL TEST
		Journal journal = new Journal();
		journal.setISSN("AAAAAAAAABBBBBBBBCCCCCCDDDDD");
		journal.setName("Journal of Computer Science");
		System.out.println(journal);
		
		// VOLUME TEST
		Volume volume = new Volume();
		volume.setVolNum(1);
		volume.setPublicationYear(1995);
		System.out.println(volume);
		
		// EDITION TEST
		Edition edition = new Edition();
		edition.setVolumeNum(1);
		edition.setEditionNum(5);
		edition.setPublicationMonth(1);
		System.out.println(edition);
		
		// JOURNALEDITOR TEST
		JournalEditor editor = new JournalEditor(user);
		editor.setChief(true);
		editor.setJournal(journal);
		System.out.println(editor);
		
		System.out.println();
		// SUBMISSION TEST
		Submission submission = new Submission();
		submission.setTitle("Systems Design");
		submission.setSummary("A description of Systems Design architecture");
		submission.setArticleContent("System Design is about .... The End.");
		System.out.println(submission);
		
		// ACCEPTED ARTICLE TEST
		AcceptedArticle article = new AcceptedArticle(submission);
		article.setStartingPage(5);
		article.setEndingPage(12);
		System.out.println(article);
		
		// AUTHOR TEST
		Authorship authorship = new Authorship(user);
		authorship.setMain(true);
		authorship.setArticle(article);
		System.out.println(authorship);
		
		System.out.println();
		// CRITIQUE TEST
		Critique critique = new Critique();
		critique.setDescription("Bad explanations");
		critique.setReply("Sorry");
		System.out.println(critique);
		
		Critique critique2 = new Critique();
		critique2.setDescription("What do you mean by ... ?");
		System.out.println(critique2);
		
		// REVIEW TEST
		Review review = new Review();
		review.setReviewerName(1);
		review.setVerdict("Strong positive");
		review.setSummary("About Systems Design");
		review.addCritique(critique2);
		review.addCritique(critique);
		System.out.println(review);
	}
}
