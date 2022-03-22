package dev.vality.dark.api.model;

import dev.vality.questionary_proxy_aggr.kontur_focus_api.KonturFocusEndPoint;
import dev.vality.questionary_proxy_aggr.kontur_focus_api.KonturFocusRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KonturFocusRequestHolder {

    private KonturFocusRequest konturFocusRequest;

    private KonturFocusEndPoint konturFocusEndPoint;

}
