package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.person.TagContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose tags contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindTagSubCommand extends FindCommand {

    private final TagContainsKeywordsPredicate predicate;

    public FindTagSubCommand(TagContainsKeywordsPredicate predicate) {
        this(predicate, false);
    }

    public FindTagSubCommand(TagContainsKeywordsPredicate predicate, boolean isExcludeMode) {
        this.predicate = predicate;
        this.isExcludeMode = isExcludeMode;
    }
    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        Predicate updatedPredicate = getMostUpdatedPredicate(model.getSearchHistoryManager(), predicate);
        model.updateFilteredPersonList(updatedPredicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindTagSubCommand // instanceof handles nulls
                && predicate.equals(((FindTagSubCommand) other).predicate)); // state check
    }
}
