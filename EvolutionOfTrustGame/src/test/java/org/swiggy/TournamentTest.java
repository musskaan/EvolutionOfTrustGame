package org.swiggy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TournamentTest {

    private TrustGame mockTrustGame;

    @BeforeEach
    public void setUp() {
        mockTrustGame = Mockito.mock(TrustGame.class);
    }

//    @Test
//    void testInvalidTournamentInitializationWithNullList_throwsRuntimeException() {
//        assertThrows(RuntimeException.class, () -> new Tournament(null));
//    }
//
//    @Test
//    void testInvalidTournamentInitializationWithEmptyList_throwsRuntimeException() {
//        assertThrows(RuntimeException.class, () -> new Tournament(Collections.emptyList()));
//    }
//
//    @Test
//    void testValidTournamentInitialization_success() {
//        List<Player> players = Arrays.asList(
//                new AlwaysCheatPlayer(), new AlwaysCheatPlayer(), new AlwaysCooperatePlayer(),
//                new CopyCatPlayer(), new CopyKittenPlayer()
//        );
//
//        Tournament tournament = new Tournament(players);
//
//        assertNotNull(tournament);
//        assertFalse(Tournament.isRunning);
//    }
//
//    @Test
//    void testPlayWithLessThan5Players_throwsRuntimeException() {
//        Tournament tournament = spy(new Tournament(List.of(new AlwaysCheatPlayer(), new AlwaysCooperatePlayer())));
//
//        assertThrows(RuntimeException.class, tournament::play);
//        verify(tournament, never()).playRound();
//    }
//
//    @Test
//    void testPlayWith5SamePlayers_throwsRuntimeException() {
//        List<Player> players = IntStream.range(0, 5).mapToObj(i -> new AlwaysCheatPlayer()).collect(Collectors.toList());
//        Tournament tournament = spy(new Tournament(players));
//
//        assertThrows(RuntimeException.class, tournament::play);
//        verify(tournament, never()).playRound();
//        assertFalse(Tournament.isRunning);
//    }
//
//    @Test
//    void testPlayWith5Players_playOneRoundSuccessfully_stopsWhenAllEliminated() {
//        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
//
//        List<Player> players = Arrays.asList(
//                alwaysCheatPlayer, new AlwaysCheatPlayer(), new AlwaysCooperatePlayer(),
//                new CopyCatPlayer(), new CopyKittenPlayer()
//        );
//        Tournament tournament = spy(new Tournament(players));
//
//        assertFalse(Tournament.isRunning);
//
//        tournament.play();
//
//        verify(alwaysCheatPlayer, times(4)).makeDecision();
//        verify(tournament, times(1)).playRound();
//        assertFalse(Tournament.isRunning);
//    }

    @Test
    void testPlayWithMultiplePlayers_playsAllRoundsSuccessfully() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());

        List<Player> players = Arrays.asList(
                new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(),
                new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(),
                new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(),
                new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(), new AlwaysCooperatePlayer(), new AlwaysCheatPlayer(),
                new AlwaysCheatPlayer(), new AlwaysCheatPlayer(), new AlwaysCheatPlayer(), new AlwaysCheatPlayer(), new CopyCatPlayer(),
                new CopyCatPlayer(), new CopyCatPlayer(), new CopyCatPlayer(), new CopyCatPlayer(), copyKittenPlayer,
                new CopyKittenPlayer(), new CopyKittenPlayer(), new CopyKittenPlayer(), new CopyKittenPlayer(), new CopyKittenPlayer()

        );
        Tournament tournament = spy(new Tournament(players));
        doNothing().when(mockTrustGame).play();

        assertFalse(Tournament.isRunning);

        tournament.play();

        verify(copyKittenPlayer, times(30)).makeDecision();
        verify(tournament, times(6)).playRound();
        assertFalse(Tournament.isRunning);
    }

//    @Test
//    void testPlayWith6Players_stopWhenAllPlayersSame() {
//        List<Player> players = Arrays.asList(
//                new AlwaysCheatPlayer(), new AlwaysCheatPlayer(), new AlwaysCheatPlayer(), new AlwaysCheatPlayer(),
//                new CopyKittenPlayer(), new AlwaysCheatPlayer()
//        );
//        Tournament tournament = spy(new Tournament(players));
//        doNothing().when(mockTrustGame).play();
//
//        assertFalse(Tournament.isRunning);
//
//        tournament.play();
//
//        verify(tournament, times(1)).playRound();
//        assertFalse(Tournament.isRunning);
//    }
}