package database_interface;

import java.util.ArrayList;

import models.AcceptedArticle;
import models.Edition;
import models.Journal;
import models.JournalEditor;
import models.User;
import models.Volume;

public interface DatabaseInterface {

	public boolean validCredentials(User user);

	public ArrayList<Journal> getAllJournals();

	public ArrayList<Volume> getAllJournalVolumes(Journal journal);

	public ArrayList<Edition> getAllVolumeEditions(Volume volume);

	public ArrayList<AcceptedArticle> getallEditionArticles(Edition edition);

	/*
	 * Creates a new Journal and appoints chiefEditor as the first main editor. If
	 * user chiefEditor does not exist in database yet, it creates this user
	 */
	public boolean createJournal(Journal newJournal, JournalEditor chiefEditor);

	/*
	 * Using the credentials of journalChief, registers user newEditor to the system
	 * and appoints this user as an editor to journalChief's journal
	 */
	public boolean addEditor(JournalEditor newEditor, JournalEditor journalChief);

	/*
	 * Using the credentials of journalChief, makes the user corresponding to
	 * newEditors email an editor of journalChief's journal
	 */
	public boolean promoteUserToEditor(JournalEditor newEditor, JournalEditor journalChief);
	
	

}
