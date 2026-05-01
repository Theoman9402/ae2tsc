# AE2 Terminal Scroll Cycling

Client-side NeoForge only addon for AE2WTLib & AE2.

Adds mouse wheel cycling for your installed terminals in the Universal Terminal.

## Features

- Scroll through your active terminals by holding down a key (not bound by default) and scrolling. 
- Uses your installed terminal order, as it would normally by the Universal Terminal.

## Requirements

- Applied Energistics 2
- AE2WTLib

## Compatibility

Works with terminals that can be added to the AE2WTLib Universal Terminal.

Tested with:

- ME Requester
- ExtendedAE
- AdvancedAE
- ExpandedAE

## Usage

1. Bind "Scroll Modifier" in Minecraft Controls.
2. Open your universal terminal, hold the key you just bound, and scroll.

## Credits

- Applied Energistics 2 
- AE2WTLib

## Implementation Notes

- Scroll input is intercepted via an `AEBaseScreen` mixin and only handled for `IUniversalTerminalCapable` screens.
- During scroll handling, the mod checks the physical keyboard or mouse input bound to `Scroll Modifier` instead of relying on cached keybind state. I tried with just reading a regular keybind but it would not register.
- Cycle behavior, including cooldown and scroll direction, is centralized in `CycleHandler`.
- Terminal switching calls AE2WTLib's existing `AE2wtlibAPI.cycleTerminal(previous)` path.

## License

MIT
