package eel.kitchen.jsonschema.validators.format;

import eel.kitchen.jsonschema.validators.AbstractValidator;
import org.codehaus.jackson.JsonNode;

import java.net.Inet6Address;
import java.net.UnknownHostException;

public final class IPv6FormatValidator
    extends AbstractValidator
{
    @Override
    protected boolean doValidate(final JsonNode node)
    {
        try {
            Inet6Address.getByName(node.getTextValue());
            return true;
        } catch (UnknownHostException e) {
            messages.add("string is not a valid IPv6 address");
            return false;
        }
    }
}
