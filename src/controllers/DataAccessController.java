package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_interface.DatabaseInterface;
import exceptions.IncompleteInformationException;
import exceptions.InvalidAuthenticationException;
import exceptions.ObjectDoesNotExistException;
import exceptions.UniqueColumnValueAlreadyExists;
import exceptions.UserAlreadyExistsException;
import exceptions.UserDoesNotExistException;
import models.AcceptedArticle;
import models.Authorship;
import models.Edition;
import models.Journal;
import models.JournalEditor;
import models.Submission;
import models.User;
import models.Volume;

public class DataAccessController implements DatabaseInterface {

	private Connection connection;
	private PreparedStatement statement;
	private String databaseURL = "jdbc:mysql://localhost/publishing_system";
	private String databaseUser = "root";
	private String databaseUserPassword = "";

	private void openConnection() throws SQLException
	{
		connection = DriverManager.getConnection(databaseURL, databaseUser, databaseUserPassword);
	}

	private void closeConnection() throws SQLException
	{
		if (connection != null)
			connection.close();
		if (statement != null)
			statement.close();
		
	}

	public void test() throws SQLException
	{
		openConnection();
		closeConnection();
		closeConnection();
	}

	public boolean userExists(User user) throws SQLException
	{
		ResultSet res = null;
		try
		{
			openConnection();

			String sqlQuery = "SELECT EXISTS(SELECT * FROM Users WHERE email=?)";
			statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, user.getEmail());

			res = statement.executeQuery();
			res.next();
			int result = res.getInt(1);

			return result == 1;
		} finally
		{
			if (res != null)
				res.close();
			
			closeConnection();
		}
	}

	@Override
	public boolean registerBaseUser(User newUser)
			throws UserAlreadyExistsException, IncompleteInformationException, SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validCredentials(User user) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Journal> getAllJournals() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Volume> getAllJournalVolumes(Journal journal) throws ObjectDoesNotExistException, SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Edition> getAllVolumeEditions(Volume volume) throws ObjectDoesNotExistException, SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AcceptedArticle> getallEditionArticles(Edition edition)
			throws ObjectDoesNotExistException, SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createJournal(Journal newJournal, JournalEditor chiefEditor) throws UserDoesNotExistException,
			InvalidAuthenticationException, UniqueColumnValueAlreadyExists, SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean promoteUserToEditor(JournalEditor newEditor, JournalEditor journalChief)
			throws UserDoesNotExistException, InvalidAuthenticationException, SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Volume createNextVolume(Journal journal, JournalEditor editor, int publicationYear)
			throws ObjectDoesNotExistException, InvalidAuthenticationException, SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edition createNextEdition(Volume volume, JournalEditor editor, String publicationMonth)
			throws ObjectDoesNotExistException, InvalidAuthenticationException, SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Submission submitArticle(Submission submission, User author)
			throws UserDoesNotExistException, InvalidAuthenticationException, SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCoAuthor(Submission submission, Authorship newAuthor, Authorship mainAuthor)
			throws UserDoesNotExistException, ObjectDoesNotExistException, InvalidAuthenticationException, SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

}
