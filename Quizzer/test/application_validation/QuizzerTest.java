package application_validation;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.assertj.swing.core.matcher.DialogMatcher;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.edt.GuiQuery;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.Quizzer;

// This test will validate that userstory 6 is working
/** 1. Initialize database
 *  2. Verify that all features' buttons appear enabled on the main menu
 */
public class QuizzerTest extends AssertJSwingTestCaseTemplate {

	protected FrameFixture frame;

    private JButtonFixture setupDb;
    private JButtonFixture createMC;
    private JButtonFixture viewQ;
    private JButtonFixture assgn;
    
	@Before
	public final void setup() {
		this.setUpRobot();
		JFrame gui = GuiActionRunner.execute(new GuiQuery<JFrame>() {
			@Override
			protected JFrame executeInEDT() throws Exception {
				Quizzer app = new Quizzer(true);
				app.frame.setPreferredSize(new Dimension(604, 402));
				app.frame.pack();
		        app.frame.setVisible(true);
				return app.frame;
			}});
		this.frame = new FrameFixture(this.robot(), gui);
		this.frame.show();
		this.setupDb = this.frame.button(JButtonMatcher.withText("Setup Database"));
		this.createMC = this.frame.button(JButtonMatcher.withText("New MC Question"));
		this.assgn = this.frame.button(JButtonMatcher.withText("Assign Questions"));
		this.viewQ = this.frame.button(JButtonMatcher.withText("View Assignment"));
	}
	
	@Test
	public void testMainMenu() {
		// Verify all buttons are enabled after a successful database setup.
		setupDb.requireVisible().requireEnabled().click();
		frame.dialog(DialogMatcher.withTitle("Success"));
		this.frame.dialog().button().click();
		createMC.requireVisible().requireEnabled();
		assgn.requireVisible().requireEnabled();
		viewQ.requireVisible().requireEnabled();
		
	}
	
	@After
	public void tearDown() {
		this.frame = null;
		cleanUp();
	}

}
