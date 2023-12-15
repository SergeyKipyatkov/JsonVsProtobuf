package ru.sberbank;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sberbank.dto.Organization;
import ru.sberbank.protobuf.OrganizationsProtos;


public class SerializeAndDeserialize {

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.Throughput)
    public static void serializationAndDeserializationJson() throws Throwable{
        ObjectMapper om = new ObjectMapper();
        Organization organization = new Organization("Pepsico", "1");

        String json = om.writeValueAsString(organization);

        Organization read = om.readValue(json, Organization.class);
//        System.out.printf("Read person: %s\n", read);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.Throughput)
    public static void protobuf(){
        String name = "CokeCola";
        String id = "2";

        OrganizationsProtos.Organization organization = OrganizationsProtos.Organization.newBuilder()
                .setName(name)
                .setId(id)
                .build();

        OrganizationsProtos.Organizations organizations = OrganizationsProtos.Organizations.newBuilder()
                .addOrganization(organization)
                .build();
    }
}
